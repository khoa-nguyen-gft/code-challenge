import java.io.File;
import java.util.Collection;
import java.util.Iterator;

public class AppFileAfter {
    void transform(File in, File out) {
        UnicodeFile unicodeFile = new UnicodeFile(in);
        FileLines fileLines = new FileLines(unicodeFile);
        Collection<String> src = new Strimmed(fileLines);

        UnicodeFile outUnicodeFile = new UnicodeFile(out);
        FileLines outFileLines = new FileLines(outUnicodeFile);
        Collection<String> dest = new Strimmed(outFileLines);
        dest.addAll(src);
    }
}

class UnicodeFile {
    public UnicodeFile(File in) {
    }
}

class FileLines implements Collection<String> {

    public FileLines(UnicodeFile unicodeFile) {
    }

	@Override
	public int size() {
		return 0;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public boolean contains(Object o) {
		return false;
	}

	@Override
	public Iterator<String> iterator() {
		return null;
	}

	@Override
	public Object[] toArray() {
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return null;
	}

	@Override
	public boolean add(String e) {
		return false;
	}

	@Override
	public boolean remove(Object o) {
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends String> c) {
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return false;
	}

	@Override
	public void clear() {
		
	}
}

class Strimmed implements Collection<String> {

    public Strimmed(FileLines fileLines) {
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<String> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return null;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(String e) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends String> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

}