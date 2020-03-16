const React = require('react');
const ReactDOM = require('react-dom'); 
import axios from "axios";
import form from './Components/form';
import { BrowserRouter, Switch, Route, Link } from 'react-router-dom'

class App extends React.Component { 

	constructor(props) {
		super(props);
		this.state = {movies: []};
	}

	componentDidMount() { 
		axios.get('/api/movies').then(res=>
			this.setState({movies: res.data._embedded.movies})

		)
	}

	render() {
		return (
			<div>
			<MovieList movies={this.state.movies}/>
			<Link to="/admin" />
			</div>
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
	<BrowserRouter>
        <Switch>
            <Route path="/" exact={true} component={App} />
            <Route path="/admin" component={form} />
        </Switch>
    </ BrowserRouter>,
	document.getElementById('react')
)