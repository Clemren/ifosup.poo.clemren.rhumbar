package managers;

import beans.Rhum;
import filters.RhumFilter;

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
                return p.getName().toLowerCase().contains(rhumFilter.getName().toLowerCase());
            });
        }
        if (!rhumFilter.getOrigin().isBlank()){
            exp = exp.and(p-> {
                return p.getOrigin().toLowerCase().contains(rhumFilter.getOrigin().toLowerCase());
            });
        }
        if (!rhumFilter.getTrademark().isBlank()){
            exp = exp.and(p-> {
                return p.getTrademark().toLowerCase().contains(rhumFilter.getTrademark().toLowerCase());
            });
        }
        if (rhumFilter.getCountryId() != 0){
            exp = exp.and(p-> {
                return p.getFk_trademark() == rhumFilter.getCountryId();
            });
        }
        return exp;
    }
}
