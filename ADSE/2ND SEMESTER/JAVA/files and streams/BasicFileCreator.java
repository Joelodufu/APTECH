import java.io.File;
import java.io.IOException;

public class BasicFileCreator {
    public static void main(String[] args) {
        File file = new File("example.txt");
        try {
            if (file.createNewFile()) {
                System.out.println("File path: " + file.getAbsolutePath());// get the absolut path
                System.out.println("File name: " + file.getName());// get the created file name

                // check file existence

            } else {
                if (file.exists()) {
                    System.out.println("The File " + file.getName() + " Exists");
                    // get the file size in Byte
                    long fileSizeInByte = file.length();
                    System.out.println("File Name: " + file.getName() + " Size in Byte: " + fileSizeInByte / 1024);

                    // check read and write capabilities
                    System.out.println(" Readability: " + file.canRead() + " \nWritability: " + file.canWrite());

                    // check if the it is a file or a directory
                    if (file.isFile()) {
                        System.out.println("This is a file");
                    } else if (file.isDirectory()) {
                        System.out.println("This is a Directory");
                        // new destination
                        File file2 = new File("file2.txt");
                        file.renameTo(file2);
                        System.out.println("The file have been renamed to " + file2.getName());
                    } else {
                        System.out.println("Unknow file type");
                    }
                }
            }
            // new destination
            File file2 = new File("file2.txt");
            file.renameTo(file2);
            System.out.println("The file have been renamed to " + file2.getName());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}