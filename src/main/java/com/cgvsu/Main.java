package com.cgvsu;

import com.cgvsu.model.Model;
import com.cgvsu.objreader.ObjReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static com.cgvsu.objwriter.ObjWriter.write;

public class Main {

    public static void main(String[] args) throws IOException {

        Path fileName = Path.of("src/main/java/com/cgvsu/3DModels/Medieval_Jug_Lowpoly_OBJ.obj");
        String fileContent = Files.readString(fileName);

        System.out.println("Loading model ...");
        Model model = ObjReader.read(fileContent);

        System.out.println("Vertices: " + model.vertices.size());
        System.out.println("Texture vertices: " + model.textureVertices.size());
        System.out.println("Normals: " + model.normals.size());
        System.out.println("Polygons: " + model.polygons.size());

        String fileNameOut = "src/main/java/com/cgvsu/output.obj";
        write(fileNameOut, model);

        System.out.println("Model has been written to " + fileNameOut);
    }
}
