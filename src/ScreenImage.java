import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilePermission;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class ScreenImage {

   private String ACCESS_TOKEN = "qkR9LWqQnYAAAAAAAAAADl4Cw9Fj7UpHMyQOcyD-WbTBiS3dc-ITE1q2lEgeRf0d";
   private DbxRequestConfig config = DbxRequestConfig.newBuilder("dropbox/java-tutorial").build();
   private DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);
   private DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd hh mm ss");



    public void robo() throws Exception {

        Calendar now = Calendar.getInstance();
        String data = dateFormat.format(now.getTime());
        Robot robot = new Robot();
        BufferedImage screenshot = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        ImageIO.write(screenshot, "JPG", new File("c:\\dmitry\\screenshot\\" + dateFormat.format(now.getTime())+".jpg"));
        System.out.println(dateFormat.format(now.getTime()));

        try (FileInputStream in = new FileInputStream( "c:\\dmitry\\screenshot\\" + data +".jpg")) {
            FileMetadata metadata = client.files().uploadBuilder("/test.jpg " + data )
                    .uploadAndFinish(in);
        } catch (Exception e){
            e.printStackTrace();
        }

    }

}
