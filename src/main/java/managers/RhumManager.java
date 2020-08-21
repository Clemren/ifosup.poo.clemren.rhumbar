package managers;

import beans.Rhum;
import filters.RhumFilter;

import java.text.Normalizer;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class RhumManager {

    public List<Rhum> getRhumSearch(RhumFilter rhumFilter, List<Rhum> rhums){
    var predicate = rhumPredicate(rhumFilter);
    var result = rhums.stream().filter(predicate);
    return result.collect(Collectors.<Rhum>toList());
    }

    public static Predicate<Rhum> rhumPredicate(RhumFilter rhumFilter){
        Predicate<Rhum> exp = p-> {
            return true;
        };
        if (!rhumFilter.getName().isBlank()){
            exp = exp.and(p-> {
                return removeDiacritics(p.getName().toLowerCase()).contains(removeDiacritics(rhumFilter.getName().toLowerCase()));
            });
        }
        if (!rhumFilter.getOrigin().isBlank()){
            exp = exp.and(p-> {
                return removeDiacritics(p.getOrigin().toLowerCase()).contains(removeDiacritics(rhumFilter.getOrigin().toLowerCase()));
            });
        }
        if (!rhumFilter.getTrademark().isBlank()){
            exp = exp.and(p-> {
                return removeDiacritics(p.getTrademark().toLowerCase()).contains(removeDiacritics(rhumFilter.getTrademark().toLowerCase()));
            });
        }

        if (!rhumFilter.getCountry().isBlank()){
            exp = exp.and(p-> {
                return p.getCountryAlphaName().toLowerCase().equals(rhumFilter.getCountry().toLowerCase());
            });
        }
        return exp;
    }



    private static String removeDiacritics(String s)
    {
        s = Normalizer.normalize(s, Normalizer.Form.NFD);
        s = s.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        return s;
    }

}
