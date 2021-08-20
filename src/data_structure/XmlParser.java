package data_structure;

// XML解析器
public class XmlParser {
    private int i;
    public String ParseXml(String xml, String path) {
        String[] node = path.split("\\.");
        for (String s : node) {
            xml = parseXml(xml, s);
        }
        return xml;
    }
    private String parseXml(String xml, String e) {
        i = 0;
        int len = xml.length();
        while (i < len) {
            if (xml.charAt(i) == '<') {
                String str = parseKey(xml);
                if (str.equals(e)) break;
            }
            i++;
        }
        i++;
        int l = i, r = -1;
        while (i < len) {
            if (i + 1 < len && xml.charAt(i) == '<' && xml.charAt(i + 1) == '/') {
                i++;
                String str = parseKey(xml);
                if (str.equals(e)) {
                    r = i - str.length() - 2;
                    break;
                }
            }
            i++;
        }
        if (r < 0) return "";
        return xml.substring(l, r);
    }
    private String parseKey(String xml) {
        int len = xml.length();
        i++;
        int j = i;
        while (i < len && xml.charAt(i) != '>') {
            i++;
        }
        return xml.substring(j, i);
    }
}
