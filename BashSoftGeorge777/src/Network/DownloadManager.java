package Network;

import IO.OutputWriter;
import StaticData.ExceptionMessages;
import StaticData.SessionData;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class DownloadManager {
    public static void download(String fileLink) {
        URL url = null;
        ReadableByteChannel rbc = null;
        FileOutputStream fos = null;
        try {
            if (Thread.currentThread().getName().equals("main")) {
                OutputWriter.writeMessageOnNewLine("Started downloading..");
            }
            url = new URL(fileLink);
            rbc = Channels.newChannel(url.openStream());
            String fileName = extractNameOfFile(url.toString());
            File file = new File(SessionData.currentPath + "/" + fileName);
            fos = new FileOutputStream(file);
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
            if (Thread.currentThread().getName().equals("main")) {
                OutputWriter.writeMessageOnNewLine("Download completed.");
            }
        } catch (MalformedURLException e) {
            OutputWriter.writeException(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rbc != null) {
                    rbc.close();
                }
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static String extractNameOfFile(String fileLink) throws MalformedURLException {
        int indexOfLastSlash = fileLink.lastIndexOf("/");
        if (indexOfLastSlash == -1) {
            throw new MalformedURLException(ExceptionMessages.INVALID_PATH);
        }
        return fileLink.substring(indexOfLastSlash + 1);
    }

    public static void downloadOnNewThread(String fileLink) {
        Thread thread = new Thread(() -> download(fileLink));
        OutputWriter.writeMessageOnNewLine(String.format("Worker thread %d started download..", thread.getId()));
        thread.setDaemon(false);
        thread.start();
    }
}

