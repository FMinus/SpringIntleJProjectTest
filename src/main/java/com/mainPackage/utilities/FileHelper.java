package com.mainPackage.utilities;

import com.mainPackage.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Ayoub on 11/4/2016.
 */
@Component
public class FileHelper
{
    private String DOC_DIR= PropretiesHelper.getText("uploads.documents");
    private String AVA_DIR= PropretiesHelper.getText("uploads.avatars");



    public User uploadAvatar(User user,MultipartFile multipart) throws IOException
    {
        user.setAvatar(saveDocument(multipart,AVA_DIR));
        return user;
    }

    public String getAvatarAbsolutePath(User user)
    {
        return AVA_DIR+user.getAvatar();
    }

    public static String getDocumentAbsolutePath()
    {
        //TODO
        return "";
    }

    public User updateAvatar(User user,MultipartFile multipartFile) throws IOException
    {
        String oldAvatarPath = getAvatarAbsolutePath(user);

        try
        {
            File oldAvatar = new File(oldAvatarPath);

            if (oldAvatar.delete())
                System.out.println(oldAvatar.getName() + " is deleted!");
            else
               System.out.println("Delete operation is failed.");
        }
        catch( Exception e)
        {
            e.printStackTrace();
        }

        try
        {
            user = uploadAvatar(user,multipartFile);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return user;
    }





    public static String hashName(String input) throws UnsupportedEncodingException, NoSuchAlgorithmException
    {
        byte[] input2bytes = input.getBytes("UTF-8");
        MessageDigest md = MessageDigest.getInstance("MD5");

        return String.valueOf(md.digest(input2bytes));
    }

    public String saveDocument(MultipartFile file,String transfertTo) throws IOException
    {
        try
        {
            File path = new File(transfertTo);
            path.mkdirs();

            String generatedFileName = hashName(file.getOriginalFilename());

            file.transferTo(new File(path+generatedFileName));

            return generatedFileName;
        }
        catch (IllegalStateException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (NoSuchAlgorithmException e)
        {
            throw new RuntimeException("Upload failed");
        }
        //FIXME
        return "error";
    }
}
