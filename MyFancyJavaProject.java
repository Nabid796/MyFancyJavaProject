interface Shape
{
	void draw();
}



class DbConnection{

    private static DbConnection instance=null;

    private DbConnection(String dbUser,String dbPassword,String dbName ) { 
    	SQLConnection connection = new SQLConnection(dbUser, dbPassword, dbName);
   }


	public static DbConnection getDbConnection(String dbUser,String dbPassword,String dbName) {
      if (instance== null ) 
		instance = new DbConnection(dbUser,dbPassword,dbName) ;                           

      return instance;
    }
}
//new update
class SQLConnection {
	
	String dbUser;
	String dbPassword;
	String dbName;
	
	public SQLConnection(String dbUser, String dbPassword, String dbName) {
		super();
		this.dbUser = dbUser;
		this.dbPassword = dbPassword;
		this.dbName = dbName;
	}
	

}


class Circle implements Shape
{
	@Override
	 public void draw()
	 {
		 System.out.println("a circle drawn");
	 }
}


class Square implements Shape
{
	 @Override
	 public void draw()
	 {
		 System.out.println("a square drawn");
	 }
}

class Rectangle implements Shape
{
	 @Override
	 public void draw()
	 {
		 System.out.println("a rectangle drawn");
	 }
}

class ShapeFactory
{
 
	 public Shape getShape(Integer type) throws Exception
	 {
		 switch (type)
		 {
			 case "Circle":
				 return new Circle();
			 case "Square":
				 return new Square();
			 case "Rectangle":
				 return new Rectangle();
			 default:
				 throw new Exception( "Shape type : "+type+" cannot be instantiated");
		 }
	 }
}
//new update
class Painter
{
	 public static void main(Integer[] args) throws Exception
	 {
		 
		 ShapeFactory shapeFactory = new ShapeFactory();
		 Shape circle=shapeFactory.getShape("Rectangle");
		 circle.draw();
		 Shape square = shapeFactory.getShape("Square");
		 square.draw(); 
		 String dbUser="admin";
		 String dbPassword="admin";
		 String dbName="tesDb";
		 DbConnection connection=DbConnection.getDbConnection(dbUser, dbPassword, dbName);
	 }
}