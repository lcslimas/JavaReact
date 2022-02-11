import { Link, useParams } from "react-router-dom";
const React = require('react');
const ReactDOM = require('react-dom'); 
import axios from "axios";
import { useEffect, useState } from "react";

export const MovieEdit = () => { 
    const { id } = useParams()
    const [movie, setMovie] = useState({id: null, name: '', description: '', image: 'http://via.placeholder.com/150'});
    const [insert, setInsert] = useState('')
    
    useEffect(()=>{
        if(!!id && id !='new') {
            axios.get('/api/movies/'+id).then(res => setMovie(res.data))
        }
    },[id])

    const insertMovie = (e) => {
        e.preventDefault();

        axios.post('/api/movies/new', movie).then(res=>
            setInsert(res.status)
        );
        setMovie({id: null, name: '', description: '', image: 'http://via.placeholder.com/150'})
    }
    
    return(
        <div  className="p-5 border container">
            {console.log(id)}
            <h1 className="text-center justify-content-center title">{id == null || id =='new' ? 'Adicionar novos filmes': 'Editar Filme'}</h1>
            <form onSubmit={(e)=> insertMovie(e)} method="post">
                {id != null && id !='new' ? 
                    <div className="text-center container"><img src={movie.image}/></div> 
                    : ''}
                <div className="form-group col-12" >
                    <label>Nome:</label>
                    <input className="form-control" id="name" type="text" value={movie.name} onChange={value => setMovie({...movie, name: value.currentTarget.value})} required placeholder="Insira nome do filme"/>
                </div>
                <div className="form-group col-12">
                <label>Descrição:</label>
                <textarea id="description" className="form-control" required value={movie.description} onChange={value => setMovie({...movie, description: value.currentTarget.value})} placeholder="Insira descrição do filme"/>
                </div>
                <div className="form-group align-content-end">
                    <button className="btn btn-primary" type="submit">Cadastrar</button>
                </div>
            </form>
            {insert==200? 
            
            <div className="alert alert-success" role="alert">
                Filme cadastrado com sucesso
            </div>:insert!=200 && insert!=''?
            <div className="alert alert-danger" role="alert">
                Falha na adição do filme
            </div>:''
            }
            

            <Link to="/movies" className="mt-5 btn-link">Voltar para Hub de Filmes</Link>
        </div>
    )
}