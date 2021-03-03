package jesuscadev.dpf.publishers;

import jesuscadev.dpf.core.Publisher;
import jesuscadev.dpf.data.DataRow;
import jesuscadev.dpf.data.DataSet;
import jesuscadev.dpf.data.DataTable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import static jesuscadev.dpf.Main.logger;

@XmlRootElement
public class XmlFilePublisher implements Publisher {
	private String name;
	private String tableName;
	private String filePath;
	private String endOfLine;
	private boolean includeHeader;

	private FileWriter fileWriter;
	private PrintWriter printWriter;
	private DataTable dataTable;

	public XmlFilePublisher() {
		endOfLine = "\n";
		includeHeader = true;
	}

	public String getName() { return name; }
	public String getTableName() { return tableName; }
	public String getFilePath() { return filePath; }
	public String getEndOfLine() { return endOfLine; }
	public boolean getIncludeHeader() { return includeHeader; }

	@XmlAttribute
	public void setName(String name) { this.name = name; }
	@XmlElement
	public void setTableName(String tableName) { this.tableName = tableName; }
	@XmlElement
	public void setFilePath(String filePath) { this.filePath = filePath; }
	@XmlElement
	public void setEndOfLine(String endOfLine) { this.endOfLine = endOfLine; }
	@XmlElement
	public void setIncludeHeader(boolean includeHeader) { this.includeHeader = includeHeader; }

	@Override
	public void publishData(DataSet dataSet) throws IOException {
		logger.entering(this.getName(), "publishData");
		logger.info(name);
		try {
			open();
			publishAll(dataSet);
		} catch (IOException e) {
			logger.severe(e.toString());
			throw e;
		} finally {
			close();
		}
		logger.exiting(this.getName(), "publishData");
	}

	private void publishAll(DataSet dataSet) throws IOException {
		/*
		dataTable = dataSet.getTable(tableName);
		if (includeHeader) {
			publishRow(dataTable.getColumnsRow(), false);
		}
		for (DataRow dataRow : dataTable.dataRows) {
			publishRow(dataRow, includeQuotes);
		}
		*/
	}

	private void publishRow(DataRow dataRow, boolean includeQuotes) throws IOException {
		/*
		if (dataRow == null) {
			return;
		}
		StringBuilder stringBuilder = new StringBuilder();
		for (int columnIndex = 0; columnIndex < dataRow.getLength(); columnIndex++) {
			if (columnIndex != 0) {
				stringBuilder.append(delimiter);
			}
			String nextValue = dataRow.getValue(columnIndex);
			if (nextValue == null) {
				continue;
			}
			if (includeQuotes && dataTable.isColumnString(columnIndex)) {
				stringBuilder.append(quotes).append(nextValue).append(quotes);
			} else {
				stringBuilder.append(nextValue);
			}
		}
		stringBuilder.append(endOfLine);
		printWriter.write(stringBuilder.toString());
		*/
	}

	private void open() throws IOException {
		/*
		fileWriter = new FileWriter(filePath);
		printWriter = new PrintWriter(fileWriter);
		*/
	}

	private void close() throws IOException {
		/*
		printWriter.close();
		fileWriter.close();
		*/
	}
}
