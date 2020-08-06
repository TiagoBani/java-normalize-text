import java.util.regex.Pattern;
import java.text.Normalizer;
import java.util.Locale;

public class Slug
{
    public static String make(String input) {
        String noseparators = SEPARATORS.matcher(input).replaceAll(":");
        String normalized = Normalizer.normalize(noseparators, Normalizer.Form.NFD);
        String slug = NONLATIN.matcher(normalized).replaceAll("");
        
        return slug.toUpperCase(Locale.ENGLISH).replaceAll("-{2,}","-").replaceAll("^-|-$","").replaceAll(":"," ");
    }
}
