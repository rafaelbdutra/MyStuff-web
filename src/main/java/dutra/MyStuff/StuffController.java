package dutra.MyStuff;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

@Resource
public class StuffController {
	
	private Result result;
	
	public StuffController(Result result) {
		this.result = result;
	}

	@Get
	@Path({"/stuff", "/stuff/"})
	public void itWorks() {
		this.result.include("message", "Yeaaaahh! It works!");
	}
}
