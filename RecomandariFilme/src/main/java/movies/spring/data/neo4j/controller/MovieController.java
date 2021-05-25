package movies.spring.data.neo4j.controller;

import movies.spring.data.neo4j.MovieDto.Details;
import movies.spring.data.neo4j.MovieDto.Result;
import movies.spring.data.neo4j.movieEntity.Movie;
import movies.spring.data.neo4j.service.MovieService;
import org.neo4j.driver.Session;
import org.neo4j.driver.internal.shaded.reactor.core.publisher.Mono;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
//@RequestMapping("/movies")
class MovieController {

	private final MovieService movieService;

	MovieController(MovieService movieService) {
		this.movieService = movieService;
	}

	@GetMapping("/movie/{title}")
	public Details findByTitle(@PathVariable("title") String title) {
		return movieService.fetchDetailsByTitle(title);
	}

	@GetMapping("/search")
	List<Result> search(@RequestParam("q") String title) {
		return movieService.searchMoviesByTitle(transform(title));
	}

	@GetMapping("/graph")
	public Map<String, List<Object>> getGraph() {
		return movieService.fetchMovieGraph();
	}

	@GetMapping("/an")
	List<Result> searchGenre(@RequestParam("an") String an) {
		return movieService.searchMoviesByYear(Integer.parseInt(an));
	}

	private static String transform(String title) {
		String result = title;
		if (result.startsWith("*")) {
			result = result.substring(1);
		}
		if (result.endsWith("*")) {
			result = result.substring(0, result.length() - 1);
		}
		return result;
	}
	@PostMapping("/recomand")
	//@ResponseStatus(HttpStatus.CREATED)
	private String createOrUpdateMovie(@RequestParam("title") String title, @RequestParam("an") String an, @RequestParam("desc") String desc) {

		Movie newMovie = new Movie(title, desc, Integer.parseInt(an));
		if(findByTitle(title) != null)
		{
			return movieService.recommend(title);
		}
		return movieService.save(newMovie);
	}
}
