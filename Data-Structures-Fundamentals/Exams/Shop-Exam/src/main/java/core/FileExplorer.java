package core;

import model.File;
import model.SampleFile;
import shared.FileManager;

import java.util.*;

public class FileExplorer implements FileManager {
    private File root;
    private Stack<File> buffer;

    public FileExplorer() {
        this.root = new SampleFile(1, "Root");
        this.buffer = new Stack<>();
    }

    @Override
    public void addInDirectory(int directorNumber, File file) {
        Stack<File> stack = new Stack<>();

        stack.push(root);

        while (!stack.isEmpty()) {
            File parent = stack.pop();

            if (parent.getNumber() == directorNumber) {
                parent.getChildren().add(file);
                return;
            }

            getChild(stack, parent);
        }
        throw new IllegalStateException();

    }

    private void getChild(Stack<File> stack, File parent) {
        for (File child : parent.getChildren()) {
            stack.push(child);
        }
    }

    @Override
    public File getRoot() {
        return this.root;
    }

    @Override
    public File get(int number) {
        File file = getFileInBfsSearch(this.root, number);

        if (file == null) {
            throw new IllegalStateException();
        }
        return file;
    }

    private File getFileInBfsSearch(File root, int number) {
        Queue<File> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            File current = queue.poll();

            if (current.getNumber() == number) {
                return current;
            }

            for (File child : current.getChildren()) {
                queue.offer(child);
            }
        }

        return null;
    }

    @Override
    public Boolean deleteFile(File file) {

        Queue<File> queue = new ArrayDeque<>();
        queue.offer(this.root);
        boolean isFound = false;

        if (root.getNumber() == file.getNumber()) {
            this.root = null;
            return true;
        }

        while (!queue.isEmpty()) {
            File current = queue.poll();

            for (File child : current.getChildren()) {
                if (child == file) {
                    isFound = true;
                    break;
                }
                queue.offer(child);
            }

            if (isFound) {
                current.getChildren().remove(file);
            }
        }
        return isFound;
    }

    @Override
    public List<File> getFilesInPath(File path) {
        List<File> resultList = new ArrayList<>();
        File currentFile = this.root;
        List<File> children = currentFile.getChildren();
        boolean isFound = false;
        while (currentFile.getNumber() != path.getNumber()) {
            List<File> childrenOfChildren = new ArrayList<>();

            for (File child : children) {
                if (child.getNumber() == path.getNumber()) {
                    resultList.addAll(child.getChildren());
                    isFound = true;
                    break;
                } else {
                    childrenOfChildren.addAll(child.getChildren());
                }
            }

            if (isFound) {
                break;
            }
            children = childrenOfChildren;
            if (children.size() == 0) {
                throw new IllegalStateException("Not found");
            }
        }

        return resultList;
    }

    @Override
    public void move(File file, File destination) {

        if (this.root.getNumber() == file.getNumber()) {
            throw new IllegalStateException();
        }

        deleteFile(file);

        File fileInBfsSearch = getFileInBfsSearch(this.root, destination.getNumber());

        fileInBfsSearch.getChildren().add(file);
    }

    @Override
    public Boolean contains(File file) {
        return getFileInBfsSearch(root, file.getNumber()) != null;
    }

    @Override
    public List<File> getInDepth() {

        List<File> result = new ArrayList<>();
        Stack<File> stack = new Stack<>();
        stack.push(this.root);

        while (!stack.isEmpty()) {
            File parent = stack.pop();
            result.add(parent);

            getChild(stack, parent);
        }
        return result;
    }

    @Override
    public List<File> getInLevel() {
        List<File> result = new ArrayList<>();

        Queue<File> queue = new ArrayDeque<>();
        queue.offer(this.root);

        while (!queue.isEmpty()) {
            File current = queue.poll();
            result.add(current);

            for (File child : current.getChildren()) {
                queue.offer(child);
            }
        }

        return result;
    }

    @Override
    public void cut(int number) {
        File fileInBfsSearch = getFileInBfsSearch(this.root, number);

        if (fileInBfsSearch == null) {
            throw new IllegalStateException();
        }
        this.buffer.push(fileInBfsSearch);
        deleteFile(fileInBfsSearch);
    }

    @Override
    public void paste(File destination) {
        File fileToPaste = this.buffer.pop();

        File fileInBfsSearch = getFileInBfsSearch(this.root, destination.getNumber());

        if (fileInBfsSearch == null) {
            throw new IllegalStateException();
        }
        fileInBfsSearch.getChildren().add(fileToPaste);
    }

    @Override
    public Boolean isEmpty() {
        return this.root.getChildren() == null;
    }

    @Override
    public String getAsString() {
        if (this.root == null) {
            return "";
        }
        StringBuilder buffer = new StringBuilder();
        print(this.root, buffer, "", "");
        return buffer.toString().trim();
    }

    private void print(File file, StringBuilder buffer, String prefix, String childrenPrefix) {
        buffer.append(prefix);
        buffer.append(file.getNumber());
        buffer.append(System.lineSeparator());
        List<File> children = file.getChildren();
        for (int i = 0; i < children.size(); i++) {
            File next = children.get(i);
            if (i < children.size() - 1) {
                print(next, buffer, childrenPrefix + "├── ", childrenPrefix + "│   ");
            } else {
                print(next, buffer, childrenPrefix + "└── ", childrenPrefix + "    ");
            }
        }
    }
}
