	package Primitives;

	public class Coordinate 
	{
	private double  _coordinate;
		
		// ***************** Constructors ********************** //

		public Coordinate()  
		{
			this. _coordinate = 0;
		}
		
		public Coordinate(double x)
		{
			this. _coordinate = x;
		}
		
		public Coordinate (Coordinate c1) 
		{
			this. _coordinate = c1. _coordinate;
		}
		
	// ***************** Getters/Setters ********************** // 

		public double get_coordinate() 
		{
			return  _coordinate;
		}

		public void set_coordinate(double x)
		{
			this. _coordinate = x;
		}

	// ***************** Administration  ******************** // 

	
		
		
		public String toString() 
		{
			return "Coordinate [x = " + _coordinate + "]";
		}
		
		// ***************** Operations ******************** //
	

		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Coordinate other = (Coordinate) obj;
			if (Double.doubleToLongBits(_coordinate) != Double
					.doubleToLongBits(other._coordinate))
				return false;
			return true;
		}

		public Coordinate Add(Coordinate c1)
		{
			return new Coordinate(this.get_coordinate()+c1.get_coordinate());
		}
		
		public Coordinate Substrct(Coordinate c1)
		{
			return new Coordinate(this.get_coordinate()-c1.get_coordinate());
		}

	}


