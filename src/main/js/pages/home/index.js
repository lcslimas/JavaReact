import React from 'react';
import axios from "axios";
import MovieList from '../../Components/MovieList';
import {Link}  from 'react-router-dom';

export default class Home extends React.Component { 

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