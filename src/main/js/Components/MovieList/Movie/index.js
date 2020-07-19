import React from 'react';
export default class Movie extends React.Component{
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