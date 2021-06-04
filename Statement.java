import java.util.ArrayList;

public class Statement
{
	protected SymbolTable symbolTable;
	protected ArrayList<Statement> Statements;
	public StatementType type;

	public Statement(SymbolTable symbolTable_, StatementType type_, ArrayList<Statement> statements_)
	{
		type = type_;
		symbolTable = symbolTable_;
		Statements = statements_;
	}

	public Statement(SymbolTable symbolTable_, StatementType type_)
	{
		type = type_;

		symbolTable = symbolTable_;

		Statements = new ArrayList<Statement>();
	}

	public Statement(SymbolTable symbolTable_)
	{
		type = StatementType.Unknown;

		symbolTable = symbolTable_;

		Statements = new ArrayList<Statement>();
	}

	public void AddStatement(Statement newStatement)
	{
		Statements.add(newStatement);
	}

	public void AddStatements(ArrayList<Statement> newStatements)
	{
		for(Statement newStatement : newStatements)
		{
				AddStatement(newStatement);
		}
	}

	// Runs itself
	public void Run()
	{
		for (Statement statement : Statements)
		{
			statement.Run();
		}
	}
}
