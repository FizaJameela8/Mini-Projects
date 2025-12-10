import React from 'react'
import Section1 from './section1/Section1'
import Section2 from './section2/Section2'


function App() {
  const users = [
  {
    id: 1,
    username: "Ariana",
    content: "UI/UX Designer and Web Developer",
    image: "https://images.unsplash.com/photo-1529626455594-4ff0802cfb7e"
  },
  {
    id: 2,
    username: "Sameer",
    content: "Full-Stack Developer",
    image: "https://images.unsplash.com/photo-1527980965255-d3b416303d12"
  },
  {
    id: 3,
    username: "Priya",
    content: "Mobile App Developer",
    image: "https://images.unsplash.com/photo-1535713875002-d1d0cf377fde"
  }
];

  return (
 <>
<Section1 users={users}/> 
<Section2 />
 </>
  )
}

export default App


