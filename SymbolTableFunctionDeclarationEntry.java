import java.util.ArrayList;

public class SymbolTableFunctionDeclarationEntry extends SymbolTableEntry
{
	
	private ArrayList<SymbolTableVariableDeclarationEntry> Parameters;
	private ArrayList<Statement> Statements;
	
	public SymbolTableFunctionDeclarationEntry(String type, String name, ArrayList<SymbolTableVariableDeclarationEntry> parameters, ArrayList<Statement> statements)
	{
		super(type, name, VariableType.Function);
		
		Parameters = parameters;
		Statements = statements;
	}
	
	public SymbolTableFunctionDeclarationEntry(String type, String name, ArrayList<SymbolTableVariableDeclarationEntry> parameters)
	{
		super(type, name, VariableType.Function);
		
		Parameters = parameters;
		Statements = new ArrayList<Statement>();
	}
	
	public SymbolTableFunctionDeclarationEntry(String type, String name)
	{
		super(type, name, VariableType.Function);
		
		Parameters = new ArrayList<SymbolTableVariableDeclarationEntry>();
		Statements = new ArrayList<Statement>();
	}
	
	@Override
	public void Print()
	{
		System.out.print("Function Name: " + Name + " | Function Type: " + Type + " | ");
		PrintParameters();
		System.out.println("");
	}
	
	public void PrintParameters()
	{
		for(SymbolTableVariableDeclarationEntry parameter : Parameters)
		{
			System.out.print("Name: " + parameter.Name + " Type: " + parameter.Type + ", ");
		}
	}
	
	public void AddStatements(ArrayList<Statement> statements)
	{
		Statements = statements;
	}
	
	public Double RunFunction(ArrayList<SymbolTableVariableDeclarationEntry> parameters)
	{
		Double outputValue = 0.0;
		if (Name.equals("Print"))
		{
			for (SymbolTableVariableDeclarationEntry parameter : parameters)
			{
				System.out.println("Expression Result: " + parameter.GetValue());
			}
			
			return outputValue;
		}
		else if (Name.equals("Mod"))
		{
			Double number = parameters.get(0).GetValue();
			Double modulo = parameters.get(1).GetValue();
			
			return number % modulo;
		}
		
		for (Statement statement : Statements)
		{
			statement.Run();
			
			if (statement.type == StatementType.Return)
			{
				ReturnStatement returnStatement = (ReturnStatement)statement;
				outputValue = returnStatement.GetValue();
				return outputValue;
			}
		}
		
		return outputValue;
	}
}