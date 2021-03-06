/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poligonsproject;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import poligonsproject.Verticles.Vertice;

/**
 *
 * @author дом
 */
public class PoligonsProject {

    public static void main(String[] args) {
        List<String> lines;
        try {
            lines = Files.readAllLines(Paths.get("C:\\Users\\дом\\Documents\\NetBeansProjects\\Poligons\\src\\poligonsproject\\poligons.json"), Charset.defaultCharset());
            String fileContents = "";
            for (String line : lines) {
                fileContents += line;
            }
            JsonElement jelement = new JsonParser().parse(fileContents);
            Gson gson = new Gson();
            Verticles verticles[] = gson.fromJson(jelement, Verticles[].class);
            if (verticles.length < 2) {
                throw new IllegalArgumentException("Json file has invalid data! Enter the correct data");
            }
            Poligon poligon = new Poligon();
            float area = 0;
            for (int i = 0; i < verticles.length; i++) {
                for (int j = i + 1; j < verticles.length; j++) {
                    if (poligon.getPoligonFromCrossTwoPoligons(verticles[i].getVertices(), verticles[j].getVertices()).size() > 2) {
                        System.out.println(String.format("Vertices from crossing poligons №%d & №%d: ", i, j)
                                + poligon.getPoligonFromCrossTwoPoligons(verticles[i].getVertices(), verticles[j].getVertices()));
                        area += poligon.getArea(poligon.getPoligonFromCrossTwoPoligons(verticles[i].getVertices(), verticles[j].getVertices()));
                    }
                }
            }
            System.out.println(String.format("Area of crossing poligons=%f", area));
        } catch (IOException ex) {
            Logger.getLogger(PoligonsProject.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
