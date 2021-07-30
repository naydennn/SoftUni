package softuni.exam.instagraphlite.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.dtos.PostSeedRootDto;
import softuni.exam.instagraphlite.models.entities.Post;
import softuni.exam.instagraphlite.repository.PostRepository;
import softuni.exam.instagraphlite.service.PictureService;
import softuni.exam.instagraphlite.service.PostService;
import softuni.exam.instagraphlite.service.UserService;
import softuni.exam.instagraphlite.util.ValidationUtil;
import softuni.exam.instagraphlite.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class PostServiceImpl implements PostService {

    private static final String POSTS_FILE_PATH = "src/main/resources/files/posts.xml";

    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;
    private final PostRepository postRepository;
    private final PictureService pictureService;
    private final UserService userService;

    public PostServiceImpl(ModelMapper modelMapper, XmlParser xmlParser, ValidationUtil validationUtil, PostRepository postRepository, PictureService pictureService, UserService userService) {
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.postRepository = postRepository;
        this.pictureService = pictureService;
        this.userService = userService;
    }

    @Override
    public boolean areImported() {
        return postRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files.readString(Path.of(POSTS_FILE_PATH));
    }

    @Override
    public String importPosts() throws IOException, JAXBException {

        StringBuilder sb = new StringBuilder();

        PostSeedRootDto postSeedRootDto = xmlParser.fromXml(POSTS_FILE_PATH, PostSeedRootDto.class);

        postSeedRootDto.getPosts().stream()
                .filter(post -> {
                    boolean isValid = validationUtil.isValid(post) &&
                            pictureService.getPicture(post.getPicture().getPath()) != null &&
                            userService.getUser(post.getUser().getUsername()) != null;

                    sb.append(isValid ? String.format("Successfully imported Post, made by %s",
                            post.getUser().getUsername()) : "Invalid Post")
                    .append(System.lineSeparator());

                    return isValid;
                })
                .map(post -> {
                    Post mappedPost = modelMapper.map(post, Post.class);

                    mappedPost.setPicture(pictureService.getPicture(post.getPicture().getPath()));
                    mappedPost.setUser(userService.getUser(post.getUser().getUsername()));

                    return mappedPost;
                })
                .forEach(postRepository::save);

        return sb.toString();
    }
}
