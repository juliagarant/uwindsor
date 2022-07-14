import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/*
Project for COMP3500
Julia Garant
104987469
Fall 2020
*/
public class filter {

    public static void main(String[] args)
    {
        BufferedImage image;
        String extension;
        Scanner scanner = new Scanner(System.in);

        //Asking the user for input, output, direction, and group size
        System.out.println("Enter the image name you want to edit: ");
        String input = scanner.nextLine();
        System.out.println("Enter output name:");
        String output = scanner.nextLine();
        System.out.println("Choose \"horizontal\" or \"vertical\" filter type: ");
        String direction = scanner.nextLine();
        System.out.println("Enter the desired group size(N): ");
        int N = scanner.nextInt();

        //Breaks up the user input into the extension (jpg,png,gif)
        extension = input.split("\\.")[input.split("\\.").length - 1];

        try
        {
            //Reading in the file
            image = ImageIO.read(new File(input));

            /*
            
            FILTER
            To be able to select at the right area of the image
            Works with an odd number of chunks
            (i+1) is put in place if it tries to swap while being the last chunk(edge)
            */
            if(direction.toLowerCase().equals("horizontal") ) {
                //HORIZONTAL
                //------------
                for (int i = 0; (i + 1) < (image.getHeight() / N); i += 2) { // Horizontal chunks
                    for (int y = i * N; y < (i * N) + N; y++) {              // Y values
                        for (int x = 0; x < image.getWidth(); x++) {         // X values
                            // swap pixel data
                            int temp = image.getRGB(x, y);
                            image.setRGB(x, y, image.getRGB(x, y + N));
                            image.setRGB(x, y + N, temp);
                        }
                    }
                }
            }
            else if(direction.toLowerCase().equals("vertical")){
                //VERTICAL
                //------------
                for (int i = 0; (i + 1) < (image.getWidth() / N); i += 2) { // Vertical chunks
                    for (int x = i * N; x < (i * N) + N; x++) {             // X values
                        for (int y = 0; y < image.getHeight(); y++) {       // Y values
                            // swap pixel data
                            int temp = image.getRGB(x, y);
                            image.setRGB(x, y, image.getRGB(x + N, y));
                            image.setRGB(x + N, y, temp);
                        }
                    }
                }
            }
            //Writing to a new file
            ImageIO.write(image, extension, new File(output + "." + extension));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
