import React from 'react'
import { MoveUpRight } from  'lucide-react';

function Left() {
  return (
    <div className='bg h-[400px] w-1/3 flex flex-col justify-between '>
        <div className='p-5'>
           <p className='text-xl font-bold'>"Build Modern & <br></br><span className='text-gray-400'>Responsive Websites</span><br></br> with React"</p>
           <p className='mt-4 bg-yellow-50 p-2 rounded-b-md border-2'>"I am a passionate front-end developer who loves building modern and responsive websites. My focus is on creating interactive and user-friendly experiences with React.js and Tailwind CSS."</p>
        </div>
        <div className='p-5 flex  gap-2'>
        <span>Learn More</span>   <MoveUpRight className='h-5 w-5 bg-white rounded-full border-2 border-amber-black '/>
        </div>
    </div>
  )
}

export default Left