public class idComparator implements Comparator<Storage>{
    public int compare(Storage s1, Storage s2){
        return s1.getId() - s2.getId();
    }
}
