import React, { useEffect, useState } from 'react';
import axios from "axios";
import { Link, useHistory } from 'react-router-dom';

export const Main = () => { 
  const[ movies, setMovies ] = useState([]);
  const[ msgExcluir, setMsgExcluir ] = useState(false);
  const { push } = useHistory();

	useEffect(()=> {
    updateMovieList();
  }, [updateMovieList])
  
  const updateMovieList = () => (
    axios.get('/api/movies').then(res=>
      setMovies(res.data)
    )
  )
  
  const remove = (e, id) => {
    e.preventDefault();
    e.stopPropagation();
    axios.delete('/api/movies/'+id).catch(() => {
      <div className="alert alert-danger" id='errorRemove' role="alert">
        Falha na remoção do filme
      </div>
    }).then(()=> {
      setMsgExcluir(true)
      updateMovieList()
    })
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

  const onMovieClick = (e, id) => {
    e.stopPropagation();
    e.preventDefault();
    push('/movies/'+id)
  }

  const Movie = ({movie: {id, image, name, description}}) => (
    <div className="col-4 p-2 movie">
      <div className="position-absolute excluir" style={{'cursor': 'pointer', 'right': '0px'}} onClick={(e)=> remove(e, id)}>X</div>
      <div className="text-center container image" onClick={(e) => onMovieClick(e, id)} style={{'cursor': 'pointer'}}><img src={image}/></div>
      <div className="text-center pt-2 border-bottom" id='name'>{name}</div>
      <div className="text-center" id='description'>{description}</div>
    </div>
  )
  
  return (
    <div className="wrapped P-5">
      <div className="alert alert-success" hidden={!msgExcluir} role="alert">
        Filme excluído com sucesso
      </div>
      <div className="container "> 
          <MovieList className="border" movies={movies}/>
          <Link to="/movies/new" className="btn-link">Ir para página de Admin</Link>
      </div>
    </div>
  )	
}


