package day07;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Day7B {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            Dir root = new Dir(null, "");
            Dir current = root;

			while ((line = reader.readLine()) != null) {
                if (line.startsWith("$")) {
                    if (line.startsWith("$ cd")) {
                        current = current.getChild(line.split(" ")[2]);
                    }
                } else {
                    Element e = null;
                    if(line.startsWith("dir")) e = new Dir(current, line.substring(4));
                    else e = new File(current, Integer.parseInt(line.split(" ")[0]), line.split(" ")[1]);
                    current.addElement(e);
                }
            }
			reader.close();

            int needed = 30000000 - (70000000 - root.getSize());
            ArrayList<Element> solutionList = getDirGreaterThan(needed, root.content);

            solutionList.sort((o1, o2) -> o1.getSize() - o2.getSize());

            System.out.println("Solution: " + solutionList.get(0).getSize());

        } catch (IOException e) {
            System.err.println(e);
        }
    }

    public static ArrayList<Element> getDirGreaterThan(int size, ArrayList<Element> c) {
        ArrayList<Element> res = new ArrayList<Element>();
        for (Element e : c) {
            if (e instanceof Dir) {
                Dir o = (Dir) e;
                if (e.getSize() >= size) res.add(e);
                res.addAll(getDirGreaterThan(size, o.content));
            }
        }
        return res;
    }
}

abstract class Element {

    Dir parent;
    String name;
    
    public Element (String name) { this.name = name; }

    //Methods for testing
    public String getPath() {
        String path = name;
        Element p = this;

        if (parent == null) return "/";

        while ((p = p.parent) != null) {
            path = p.name + "/" + path;
        }

        return path;
    }

    public boolean equals(Object o) {
        if (!(o instanceof Element)) return false;
        Element e = (Element) o;
        return e.getPath().equals(this.getPath());
    }

    public String toString() {
        return this.getPath();
    }
    //---------------------------

    public abstract int getSize();
}

class Dir extends Element {
    ArrayList<Element> content;

    public Dir(Dir parent, String name) {
        super(name);
        this.parent = parent;
        this.content = new ArrayList<Element>();
    }

    public void addElement(Element e) {
        if (!content.contains(e)) content.add(e);
    }

    public Dir getChild (String name) {
        if (name.equals("..")) return parent;
        Dir res = null;
        for (Element e : content) {
            if(e instanceof Dir && e.name.equals(name)) {
                res = (Dir) e;
            } 
        }
        return res;
    }

    public int getSize() {
        int res = 0;
        for (Element e : content) {
            res += e.getSize();
        }
        return res;
    }
}

class File extends Element {
    int size;

    public File (Dir parent, int size, String name) {
        super(name);
        this.parent = parent;
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}