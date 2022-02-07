import React, { useEffect, useState } from 'react';
import axios from "axios";
import { Link } from 'react-router-dom';

export const Main = () => { 
  const[ movies, setMovies ] = useState([]);

	useEffect(()=> {
    updateMovieList();
  }, [updateMovieList])
  
  const updateMovieList = () => (
    axios.get('/api/movies').then(res=>
      setMovies(res.data)
    )
  )
  
  const remove = (id) => {
    axios.delete('/api/movies/'+id).catch(() => {
      <div className="alert alert-danger" id='errorRemove' role="alert">
        Falha na remoção do filme
      </div>
    }).then(updateMovieList)
  }

  const MovieList = () =>{
    const movie = movies.map(movie =>
      <Movie key={movie.id} movie={movie}/>
    );
    return (
      <div className="col-12 row border mb-3">
        {movie}
      </div>
    )
  }

  const Movie = ({movie: {id, image, name, description}}) => (
      <div className="col-4 p-2">
        <div className="position-absolute" style={{'cursor': 'pointer', 'right': '0px'}} onClick={()=> remove(id)}>X</div>
        <div className="text-center container"><img src={image}/></div>
        <div className="text-center pt-2 border-bottom">{name}</div>
        <div className="text-center">{description}</div>
      </div>
  )
  
  return (
    <div className="wrapped P-5">
      <div className="container "> 
        <h1 className="text-center justify-content-center d-flex row">BusterFlix</h1>
          <MovieList className="border" movies={movies}/>
          <Link to="/admin" className="btn-link">Ir para página de Admin</Link>
      </div>
    </div>
  )	
}


