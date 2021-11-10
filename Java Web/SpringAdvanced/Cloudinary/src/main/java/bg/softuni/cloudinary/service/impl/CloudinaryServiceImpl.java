package bg.softuni.cloudinary.service.impl;

import bg.softuni.cloudinary.service.CloudinaryImage;
import bg.softuni.cloudinary.service.CloudinaryService;
import com.cloudinary.Cloudinary;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@Service
public class CloudinaryServiceImpl implements CloudinaryService {

    private static final String TEMP_FILE = "temp-file";
    private static final String URL = "url";
    private static final String PUBLIC_ID = "public_id";

    private final Cloudinary cloudinary;

    public CloudinaryServiceImpl(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }

    @Override
    public CloudinaryImage upload(MultipartFile multipartFile) throws IOException {

        File tempFile = File.createTempFile(TEMP_FILE, multipartFile.getOriginalFilename());
        multipartFile.transferTo(tempFile);

        CloudinaryImage cloudinaryImage = null;
        try {
            @SuppressWarnings("unchecked")
            Map<String, String> uploadResult = cloudinary.
                    uploader().
                    upload(tempFile, Map.of());

            String url = uploadResult.getOrDefault(URL, "https://www.google.com/search?q=image+not+found&sxsrf=AOaemvKIYmlrbf9q8oKJ0vUuYtLZZfsIRg:1636534624674&tbm=isch&source=iu&ictx=1&fir=go0xj-MtnwrOJM%252Crb42RVdX5acoCM%252C_%253BChBJG83P3qpRbM%252CxVwqYIVUdXUeHM%252C_%253BqkTc8mRrKbQ6aM%252CJ3jUg03J2_ZkxM%252C_%253BX6ukzMYzOj0GaM%252CR-3sT7WRr1OwYM%252C_%253B1Hcr6MmWtkOBSM%252CoJz1yYsIZ-24sM%252C_%253BAXK1OmDRv7BqKM%252CS7hc8UZhraP9iM%252C_%253BJPT257CYeJobEM%252CBJQUxnfZrdTLXM%252C_%253BJQDPf07Li2Eu1M%252CgrWb3R2wvjO76M%252C_%253Bs1erkYOt7dh3sM%252CS7hc8UZhraP9iM%252C_%253Bd8JUAyMiV3FWkM%252CdR0eSLrqd8WneM%252C_%253BDJ_zcSBiWhuElM%252C9lFFg5WxqDCPUM%252C_%253B-FeCDevOqDc4oM%252CxVr5hFnF9POQ6M%252C_%253BtFN9D1ql_6ZtXM%252C8oz9bGxV4sCAdM%252C_%253BYQkwM7ySiNVkfM%252C1iweBauSQpIgKM%252C_%253BQmsBtkId78nvCM%252CNxZeD1d7TApzaM%252C_&vet=1&usg=AI4_-kRsZyASv_kTnS3076foASuusFucgg&sa=X&sqi=2&ved=2ahUKEwjp_tzHto30AhXMlmoFHcZdDW0Q9QF6BAgIEAE&biw=1536&bih=722&dpr=1.25#imgrc=ChBJG83P3qpRbM");
            String publicId = uploadResult.getOrDefault(PUBLIC_ID, "");

            cloudinaryImage = new CloudinaryImage().
                    setPublicId(publicId).
                    setUrl(url);
        } finally {
            tempFile.delete();
        }
        return cloudinaryImage;
    }

    @Override
    public boolean delete(String publicId) {
        try {
            this.cloudinary.uploader().destroy(publicId, Map.of());
        } catch (IOException e) {
            return false;
        }
        return true;
    }
}
