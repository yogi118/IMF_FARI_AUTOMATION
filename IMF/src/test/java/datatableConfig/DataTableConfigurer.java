package datatableConfig;

import java.util.Locale;
import java.util.Map;

import cucumber.api.TypeRegistry;
import cucumber.api.TypeRegistryConfigurer;
import datatableDTOs.APIResponse;
import io.cucumber.datatable.DataTableType;
import io.cucumber.datatable.TableEntryTransformer;

public class DataTableConfigurer implements TypeRegistryConfigurer{

	@Override
	public Locale locale() {
		return Locale.ENGLISH;
	}

	@Override
    public void configureTypeRegistry(TypeRegistry registry) {
        registry.defineDataTableType(new DataTableType(APIResponse.class, new TableEntryTransformer<APIResponse>() {
            @Override
            public APIResponse transform(Map<String, String> entry) {
                return new APIResponse(entry.get("algorithm"), entry.get("transid"), entry.get("forecast"));
            }
        }));
    }

}
