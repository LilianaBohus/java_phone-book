import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class Telefonkonyv extends AbstractTableModel {

public List<Nevjegy> telefonkonyv = new ArrayList<Nevjegy>();

// Leellenorzi, hogy van e mar a telefonkonyvben egy ugyanilyen rekord.
public boolean isOverride(Nevjegy n) {
	for (Nevjegy nevjegy : telefonkonyv) {
		if (nevjegy.equals(n)) {
			return true;
		}
	}
	return false;
}

public void addNevjegy(Nevjegy n) throws OverrideException {
	if (this.isOverride(n)) {
		throw new OverrideException();
	}
	else {
	telefonkonyv.add(n);
	fireTableDataChanged();
	}
}

public int keresNevSzerint(String n) {
	for (int i=0; i<telefonkonyv.size(); i++) {
		if (telefonkonyv.get(i).getNev().matches(n+".*"))
			return i;
	}
	return -1;
}

@Override
public int getColumnCount() {
	return 5;
}

public String getColumnName(int columnIndex) {
	switch (columnIndex) {
	case 0:
		return "Név";
	case 1:
		return "Telefonszám";
	case 2:
		return "Foglalkozás";
	case 3:
		return "Lakcím";
	default:
		return "Email";
	}
}

@Override
public int getRowCount() {
	return telefonkonyv.size();
}

@Override
public Object getValueAt(int rowIndex, int columnIndex) {
	switch (columnIndex) {
	case 0:
		return telefonkonyv.get(rowIndex).getNev();
	case 1:
		return telefonkonyv.get(rowIndex).getTelefonszam();
	case 2:
		return telefonkonyv.get(rowIndex).getFoglalkozas();
	case 3:
		return telefonkonyv.get(rowIndex).getLakcim();
	default:
		return telefonkonyv.get(rowIndex).getEmail();
	}
}

public void lement(File file) {
	try {
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
		outputStream.writeObject(telefonkonyv);
		outputStream.close();
		fileOutputStream.close();
	} catch (IOException e) {
		// e.printStackTrace();
	}

}
	

public void betolt(File file) {
	try {
		FileInputStream fileInputStream = new FileInputStream(file);
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		telefonkonyv = (ArrayList<Nevjegy>) objectInputStream.readObject();
		objectInputStream.close();
		fileInputStream.close();
	} catch (IOException e) {
		// e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// e.printStackTrace();
	}
	
}

public Nevjegy torol(int rowIndex) {
	Nevjegy nevjegy = telefonkonyv.remove(rowIndex);
	fireTableDataChanged();
	return nevjegy;
}


}
