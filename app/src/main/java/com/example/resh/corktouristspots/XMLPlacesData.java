package com.example.resh.corktouristspots;

import android.content.Context;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class XMLPlacesData {

    private Context context;
    private Place [] data;

    public XMLPlacesData(Context context) {
        this.context = context;

        // get to stream to xml and parse it
        InputStream stream = this.context.getResources().openRawResource(R.raw.places);
        DocumentBuilder builder = null;
        Document document = null;
        try {
            builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            document = builder.parse(stream);

        } catch (Exception e) {

        }

        // extract the nodelists for name, address, etc
        NodeList nameList = document.getElementsByTagName("name");
        NodeList addressList = document.getElementsByTagName("address");
        NodeList descriptionList = document.getElementsByTagName("description");
        NodeList distanceList = document.getElementsByTagName("distance");
        NodeList firstImageList = document.getElementsByTagName("image1");
        NodeList secondImageList = document.getElementsByTagName("image2");
        NodeList thirdImageList = document.getElementsByTagName("image3");
        NodeList urlList = document.getElementsByTagName("url");
        NodeList backgroundImageList = document.getElementsByTagName("background");

        data = new Place[nameList.getLength()];

        // traverse this nodelist to populate data
        for(int i=0; i < nameList.getLength(); i++) {

            //extract name, address, etc
            String name = nameList.item(i).getFirstChild().getNodeValue();
            String description = descriptionList.item(i).getFirstChild().getNodeValue();
            String address = addressList.item(i).getFirstChild().getNodeValue();
            String distance = distanceList.item(i).getFirstChild().getNodeValue();
            String [] images = {firstImageList.item(i).getFirstChild().getNodeValue(),
                    secondImageList.item(i).getFirstChild().getNodeValue(),
                    thirdImageList.item(i).getFirstChild().getNodeValue()
            };
            String url = urlList.item(i).getFirstChild().getNodeValue();
            String backgroundImage = backgroundImageList.item(i).getFirstChild().getNodeValue();

            //make a Place object
            Place p = new Place(name, description, address, distance, images, url, backgroundImage);

            //add it to data
            data[i] = p;

        }


    }

    public Place getPlaceData(int i) {
        return data[i];
    }

    public String [] getNames() {

        String [] names = new String[data.length];
        for (int i = 0; i < data.length; i++) {
            names[i] = data[i].getName();
        }
        return names;
    }

    public String [] getAddresses() {

        String [] addresses = new String[data.length];
        for (int i = 0; i < data.length; i++) {
            addresses[i] = data[i].getAddress();
        }
        return addresses;
    }

    public String [] getImages() {

        String [] images = new String[data.length];
        for (int i = 0; i < data.length; i++) {
            images[i] = data[i].getImage();
        }
        return images;
    }

    public int getLength() {
        return data.length;
    }

}
