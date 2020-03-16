import React from 'react';
import ReactDOM from 'react-dom'; 
import axios from "axios";
import form from './form';
import Header from './Components/Header';

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
			<div className="wrapped P-5">
				<div className="container "> 
					<h1 className="text-center justify-content-center d-flex row">BusterFlix</h1>
						<MovieList className="border" movies={this.state.movies}/>
					<Link to="/admin" className="btn-link">Ir para página de Admin</Link>
				</div>
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
			<div className="col-12 row border mb-3">
					{movie}
			</div>
		)
	}
}

class Movie extends React.Component{
	render() {
		return (
			<div className="col-4 p-2">
				<div className="text-center container"><img src={this.props.movie.image}/></div>
				<div className="text-center pt-2 border-bottom">{this.props.movie.name}</div>
				<div className="text-center">{this.props.movie.description}</div>
			</div>
		)
	}
}

ReactDOM.render(
	<BrowserRouter>
	<Header />
        <Switch>
            <Route path="/" exact={true} component={App} />
            <Route path="/admin" component={form} />
        </Switch>
    </ BrowserRouter>,
	document.getElementById('react')
)