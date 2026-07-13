package com.cognizant.engineering.factory;

interface Document {
    String open();
}

class WordDocument implements Document {
    public String open() { return "Opening Word document"; }
}

class PdfDocument implements Document {
    public String open() { return "Opening PDF document"; }
}

class ExcelDocument implements Document {
    public String open() { return "Opening Excel document"; }
}

abstract class DocumentFactory {
    abstract Document createDocument();
    String preview() { return createDocument().open(); }
}

class WordDocumentFactory extends DocumentFactory {
    Document createDocument() { return new WordDocument(); }
}

class PdfDocumentFactory extends DocumentFactory {
    Document createDocument() { return new PdfDocument(); }
}

class ExcelDocumentFactory extends DocumentFactory {
    Document createDocument() { return new ExcelDocument(); }
}

public class DocumentFactoryDemo {
    public static void main(String[] args) {
        DocumentFactory[] factories = { new WordDocumentFactory(), new PdfDocumentFactory(), new ExcelDocumentFactory() };
        for (DocumentFactory factory : factories) {
            System.out.println(factory.preview());
        }
    }
}
