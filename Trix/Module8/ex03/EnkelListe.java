class EnkelListe {
    private Node start;

    public void settInnForan(String nyttInnhold) {
        Node ny = new Node(nyttInnhold);
        ny.neste = start;
        start = ny;
    }

    public void skrivUt() {
        /*Node tmp = start;
        while (tmp != null) {
            System.out.println(tmp.innhold);
            tmp = tmp.neste;
        }*/
        skrivUtBaklengs(start);
    }

    private class Node {
        private String innhold;
        private Node neste;

        Node(String s) {
            innhold = s;
        }
    }

    private void skrivUtBaklengs(Node n){

      while (n != null){
        skrivUtBaklengs(n.neste);
        System.out.println(n.innhold);
        return;
      }
    }
}
