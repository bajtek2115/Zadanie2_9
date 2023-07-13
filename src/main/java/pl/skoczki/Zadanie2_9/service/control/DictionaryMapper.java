package pl.skoczki.Zadanie2_9.service.control;

import org.springframework.stereotype.Component;
import pl.skoczki.Zadanie2_9.service.entity.Country;
import pl.skoczki.Zadanie2_9.service.entity.DictItem;

import java.util.Arrays;
import java.util.List;

@Component
public class DictionaryMapper {

    public List<DictItem> mapCountries(Country[] countries) {
        return Arrays.stream(countries)
                .map(c -> new DictItem(c.getDisplayName(), c.name()))
                .toList();
    }
}