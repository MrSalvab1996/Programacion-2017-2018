package salvador_bauza_exerciciclases_v2;
//@author Salvador Bauza 
//1º DAM

public class Salvador_Bauza_ExerciciClases_v2 {

    //Clase Book, publica, esta clase contiene la informacion de los libros de
    //la libreria.
    public static class Book {
    
        //Inicializamos los atributos de la clase Book, en este caso todos son
        //privados.
        private String name;
        private double price;
        private int qty;
        private Author[] authors;
        
        //Primer constructor de la clase Book, precisa de 4 parametros de entrada
        //que correspondedn a: una String para el nombre del libro, un double
        //para el precio, un integer para la cantidad y una matriz de autores
        //para los autores del libro.
        public Book (String new_name, double new_price, int new_qty, Author[] new_authors){
        
            this.name = new_name;
            this.price = new_price;
            this.qty = new_qty;
            this.authors = new_authors;
        }
        
        //Segundo contructror de la clase Book, posee los mismos parametros de
        //entrada que el anterior constructor a excepcion de la cantidad.
        public Book (String new_name, double new_price, Author[] new_authors){
        
            this.name = new_name;
            this.price = new_price;
            this.authors = new_authors;
        }
        
        //Metodo getter para el atributo Name, devuelve el valor de name.
        public String getName () {
        
            return this.name;
        }
        
        //Metodo getter para el atributo Author[], este atributo es un array
        //de la clase Author, devuelve los atributos de la clase Author.
        public Author[] getAuthors() {
        
            return this.authors;
        }
        
        //Metodo getter para el atributo Price, devuelve el valor de Price.
        public double getPrice () {
        
            return this.price;
        }
        
        //Metodo setter para el atributo Price, precisa de un double como 
        //parametro de entrada, el cual se asignara a this.price, no devuelve valor.
        public void setPrice (double new_price) {
        
            this.price = new_price;
        }
        
        //Metodo getter para el atributo qty, devuelve el valor de qty.
        public int getQty () {
        
            return this.qty;
        }
        
        //Metodo setter para el atributo qty, precisa de un int como 
        //parametro de entrada, el cual se asignara a this.qty, no devuelve valor.
        public void setQty (int new_qty) {
        
            this.qty = new_qty;
        }
        
        //Este metodo devuelve toda la informacion referente a Book, en una sola
        //string que despues puede ser imprimida por pantalla.
        public String toString (){
            String author = "";
            for (int loop =0; loop < this.authors.length; loop++){

                author = author + "name= "+this.authors[loop].name+", email="+this.authors[loop].email+
                        ", gender="+this.authors[loop].gender+" ";

            }
          return "Book [name ="+this.name+",authors={"+author+"}, price="+this.price+", qty="+this.qty+"]";
        }
       
        //Similar al metodo anterior, este metodo devuelve el nombre de los autores
        //de un libro.
        public String getAuthorNames (){
            String author_names = "";
            for (int loop =0; loop < this.authors.length; loop++){
                author_names = author_names + this.authors[loop].name+", ";
            }
            return author_names;
        }
    }
    
    //Clase donde se almacenan los datos de los autores.
    public static class Author {
    
        //Atributos de la clase, tambien como en la anterior claase, todos privados.
        private String name;
        private String email;
        private char gender;
    
        //Constructor de la clase Author, precisa de los parametros de entrada de
        //un string para el nombre, otra string para un email y un char para el genero.
        public Author (String new_name, String new_email, char new_gender){
        
            this.name = new_name;
            this.email = new_email;
            this.gender = new_gender;
        }
    }
    
    
    public static void main(String[] args) {
        
        //Instanciamos 3 autores mediante el unico contructor de la clase Author.
        Author a1 = new Author("Salva", "sbauza@nigul.cide.es", 'm');
        Author a2 = new Author("Hugo", "hgavela@nigul.cide.es", 'm');
        Author a3 = new Author("Espi", "despinoisa@nigul.cide.es", 'm');
        
        //Guardamos los autores en arrays en funcion de los libros eszcritos.
        Author[] a = {a1};
        Author[] b = {a2, a3};
        
        //Instanciamos 2, cada uno usando un construcotr distintro de la clase Book
        Book b1 = new Book("Como amar a tu profesor de prgramacion", 12.50, 3, a);
        Book b2 = new Book("El libro olvidado", 11.25, b);
        
        //Mostramos por pantalla el resultado de los metodos toString y getAuthorNames
        //de ambos libros.
        System.out.println("Primer libro "+b1.toString());
        System.out.println("");
        System.out.println("Segundo ligro "+b2.toString());
        System.out.println("");
        System.out.println("Autor/es de "+b1.name+ " es/son "+b1.getAuthorNames());
        System.out.println("");
        System.out.println("Autor/es de "+b2.name+ " es/son "+b2.getAuthorNames());

    }
    
}
