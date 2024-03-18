package com.bah.tahi.bmoonlinebet.generator;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class OpenXavaCodeGenerator {

	private static class ClassInfo {
		String className;
		List<String> attributes;
		List<String> associations;
	}

	public static void generateClassesFromDotUml(String dotUmlFilePath) {
		try {
			String classDiagram = readDotUmlFile(dotUmlFilePath);

			List<ClassInfo> classInfos = extractClassInfo(classDiagram);

			for (ClassInfo classInfo : classInfos) {
				generateClass(classInfo);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static String readDotUmlFile(String dotUmlFilePath) throws IOException {
		StringBuilder content = new StringBuilder();
		try (BufferedReader reader = new BufferedReader(new FileReader(new File(dotUmlFilePath)))) {
			String line;
			while ((line = reader.readLine()) != null) {
				content.append(line).append("\n");
			}
		}
		return content.toString();
	}

	private static List<ClassInfo> extractClassInfo(String classDiagram) {
		List<ClassInfo> classInfos = new ArrayList<>();
		Pattern classPattern = Pattern.compile("class (\\w+) \\{([^}]*)\\}");
		Matcher classMatcher = classPattern.matcher(classDiagram);

		while (classMatcher.find()) {
			ClassInfo classInfo = new ClassInfo();
			classInfo.className = classMatcher.group(1);
			classInfo.attributes = extractAttributes(classMatcher.group(2));
			classInfo.associations = extractAssociations(classMatcher.group(2));
			classInfos.add(classInfo);
		}

		return classInfos;
	}

	private static List<String> extractAttributes(String classBody) {
		List<String> attributes = new ArrayList<>();
		Pattern attributePattern = Pattern.compile("private\\s+(\\w+\\s+\\w+)\\s*;");
		Matcher attributeMatcher = attributePattern.matcher(classBody);

		while (attributeMatcher.find()) {
			attributes.add(attributeMatcher.group(1));
		}

		return attributes;
	}

	private static List<String> extractAssociations(String classBody) {
		List<String> associations = new ArrayList<>();
		Pattern associationPattern = Pattern.compile("\\s+(\\w+)\\s+-[gc]->\\s+\\w+");
		Matcher associationMatcher = associationPattern.matcher(classBody);

		while (associationMatcher.find()) {
			associations.add(associationMatcher.group(1));
		}

		return associations;
	}

	private static void generateClass(ClassInfo classInfo) {
		StringBuilder classCode = new StringBuilder();

		// Package declaration
		classCode.append("package ").append(classInfo.className.toLowerCase()).append(";\n\n");

		// Import statements
		classCode.append("import javax.persistence.*;\n\n");

		// Class declaration
		classCode.append("@Entity\n");
		classCode.append("public class ").append(classInfo.className).append(" {\n\n");

		// Attributes
		for (String attribute : classInfo.attributes) {
			classCode.append("    private ").append(attribute).append(";\n");
		}

		// Associations
		for (String association : classInfo.associations) {
			classCode.append("    @ManyToOne\n");
			classCode.append("    private ").append(association).append(";\n");
		}

		// Default constructor
		classCode.append("\n");
		classCode.append("    // Default constructor\n");
		classCode.append("    public ").append(classInfo.className).append("() {}\n\n");

		// Getters and setters
		for (String attribute : classInfo.attributes) {
			String attributeName = attribute.split(" ")[1];
			String attributeType = attribute.split(" ")[0];
			classCode.append("    public ").append(attributeType).append(" get").append(capitalize(attributeName))
					.append("() {\n");
			classCode.append("        return ").append(attributeName).append(";\n");
			classCode.append("    }\n\n");

			classCode.append("    public void set").append(capitalize(attributeName)).append("(").append(attributeType)
					.append(" ").append(attributeName).append(") {\n");
			classCode.append("        this.").append(attributeName).append(" = ").append(attributeName).append(";\n");
			classCode.append("    }\n\n");
		}

		// Closing brace for the class
		classCode.append("}\n");

		// Save the code to a file
		saveToFile(classInfo.className.toLowerCase(), classInfo.className, classCode.toString());
	}

	private static String capitalize(String str) {
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}

	private static void saveToFile(String packageName, String className, String code) {
		try {
			File packageDir = new File("src/main/java/com/bah/tahi/bmoonlinebet/generator/models/");// + packageName);
			packageDir.mkdirs();

			File file = new File(packageDir, className + ".java");
			FileWriter writer = new FileWriter(file);
			writer.write(code);
			writer.close();

			System.out.println("Generated: " + file.getAbsolutePath());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// Exemple d'utilisation avec un fichier .dotuml
		String dotUmlFilePath = "src/main/java/com/bah/tahi/bmoonlinebet/generator/ClassDiagram.dotuml";
		generateClassesFromDotUml(dotUmlFilePath);
	}
}
