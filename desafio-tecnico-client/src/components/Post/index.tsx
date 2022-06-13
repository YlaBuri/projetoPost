import React, { useState } from 'react';
import Box from '@mui/material/Box';
import Button from '@mui/material/Button';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import Typography from '@mui/material/Typography';
import KeyboardArrowUpIcon from '@mui/icons-material/KeyboardArrowUp';
import axios from 'axios';

export default function Post(props: {id: number, texto: string, dataPostagem: Date, upvote: number}){
    const {id, texto, dataPostagem, upvote} = props

    const [valor, setvalor] = useState(upvote)

    const editar = (id: number) => {
        axios.put(`http://localhost:8080/posts/${id}`)
        .then(resposta =>{
            console.log(resposta)
            setvalor(resposta.data.upvote)
        })
    }

    return(
        
            <Box sx={{ display: 'flex', boxShadow: 1 ,  borderRadius: 1 ,  p: 2, m:2}}>
                <Box sx={{ display: 'flex', alignItems: 'center', flexDirection: 'column' }}>
                    <CardContent >
                        <Button onClick={() => editar(id)} variant="outlined"><KeyboardArrowUpIcon></KeyboardArrowUpIcon></Button>
                        <Typography component="div" variant="h3">
                            {valor}
                        </Typography>
                    </CardContent>
                </Box>
                <Box sx={{ display: 'flex', flexDirection: 'column' }}>
                    <CardContent sx={{ flex: '1 0 auto' }}>
                        <Typography component="div" variant="subtitle1">
                        {texto}
                        </Typography>
                    </CardContent>
                </Box>
            </Box>
    )
}