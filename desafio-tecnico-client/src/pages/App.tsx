import Box from '@mui/material/Box';
import axios from 'axios';
import React, { useEffect, useState } from 'react';
import CadastrarPost from '../components/CadastrarPost';
import Post from '../components/Post';
import { IPost } from '../types/IPost';

function App() {
  // const posts : IPost[] = [
  //   {
  //     id : 1,
  //     texto: "aaaaa",
  //     dataPostagem: new Date(),
  //     upvote: 0
  //   }
  // ]

  const [posts, setPosts] = useState<IPost[]>([])

  useEffect(()=>{
    //obter lista
    axios.get<IPost[]>('http://localhost:8080/posts')
      .then(resposta =>{
        setPosts(resposta.data)
      })
      .catch(erro =>{
        console.log(erro)
      })
  }, [])

  return (
    <Box sx={{display: 'flex', alignItems: 'center', 
    flexDirection: 'column',}}>
      
      <Box sx={{width: '50%', alignItems: 'center'}}>
        <CadastrarPost/>
      </Box>

      <Box sx={{width: '50%', alignItems: 'center'}}>
        {posts.map((item, index) => (
          <Post key={index}
          {...item}/>
        ))}
      </Box>

      </Box>
  );
}

export default App;
