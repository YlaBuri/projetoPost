import React, { useEffect, useState } from 'react';
import Button from '@mui/material/Button';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import TextField from '@mui/material/TextField';
import axios from 'axios';
import Box from '@mui/material/Box';

export default function CadastrarPost(){

    

    const [texto, setTexto] = useState('')

    const enviar = (evento: React.FormEvent<HTMLFormElement>) =>{
        //evento.preventDefault()
        axios.post("http://localhost:8080/posts", {texto: texto})
        .then(()=>
            console.log("cadastrado")
        )
        // console.log('enviar dados para a API:')
        // console.log(texto)
    }
    
    return(
        <Box sx={{ display: 'flex', flexDirection: 'column',  p: 2, m:2 }}>
            <form onSubmit={enviar}>
                <div className='inputContainer'>      
                    <TextField
                    fullWidth 
                    value={texto}
                    onChange={evento => setTexto(evento.target.value)}
                    id="post"
                    label="No que está pensando"
                    placeholder="No que está pensando"
                    multiline
                    />
                </div>
                <Button type="submit"  variant="contained" sx={{ mt:2}}>Enviar</Button>
            </form>
        </Box>
    )
}