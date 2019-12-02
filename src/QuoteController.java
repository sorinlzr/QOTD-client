public class QuoteController {
    public static void main(String[] args) {
        QuoteModel quoteModel;
        if(args.length<2){
            quoteModel = new QuoteModel("djxmmx.net", 17);
        }

        else {
            String hostname = args[0];
            int port = Integer.parseInt(args[1]);
            System.out.println("Trying to reach host: "+hostname +":"+port);
            quoteModel = new QuoteModel(hostname, port);
        }

        QuoteView quoteView = new QuoteView(quoteModel);
    }
}
