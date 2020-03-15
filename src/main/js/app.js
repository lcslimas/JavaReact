const React = require('react');
const ReactDOM = require('react-dom'); 
const client = require('./client');

class App extends React.Component { 

	constructor(props) {
		super(props);
		this.state = {movies: []};
	}

	componentDidMount() { 
		client({method: 'post', path: '/api/insert'}).done(response => {
			console.log(response)
		});
	}

	render() {
		return (
			<MovieList movies={this.state.movies}/>
		)
	}
	
}

class MovieList extends React.Component{
	render() {
		const movie = this.props.movies.map(movie =>
			<Movie key={movie._links.self.href} movie={movie}/>
		);
		return (
			<table>
				<tbody>
					<tr>
						<th>Nome</th>
						<th>Descrição</th>
					</tr>
					{movie}
				</tbody>
			</table>
		)
	}
}

class Movie extends React.Component{
	render() {
		return (
			<tr>
				<td>{this.props.movie.name}</td>
				<td>{this.props.movie.description}</td>
			</tr>
		)
	}
}

ReactDOM.render(
	<App />,
	document.getElementById('react')
)