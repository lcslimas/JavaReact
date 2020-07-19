import React from 'react';
import Movie from './Movie'

export default class MovieList extends React.Component{
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