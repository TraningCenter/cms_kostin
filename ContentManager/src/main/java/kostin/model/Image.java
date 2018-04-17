package kostin.model;

public class Image implements Comparable<Image>{

    private byte[] bytes;

    private String hash;

    private String name;



    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public int compareTo(Image o) {
        if (this.getHash().equals(o.getHash())){
            return 0;
        }
       if (this.getHash().length()>o.getHash().length()){
           return 1;
       }else {
           return -1;
       }
    }
}
