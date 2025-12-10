import React from 'react'
import { MoveUpRight } from 'lucide-react';

export default function RightCardContent() {
  return (
    
    <div className='absolute top-0 left-0 p-7 h-full w-full flex flex-col justify-between items-start'>

      <div className='bg-white rounded-full w-6'>
        <p className='text-center'>1</p>
      </div>

      <div className='w-full'>
        <div className='text-white'>
          <h1>Username</h1>
          <p>content here</p>
        </div>

        <div className='flex justify-between w-full mt-3'>
          <button className='text-white bg-blue-400 p-2 rounded-2xl hover:bg-blue-900'>
            learn more
          </button>

          <button className='rounded-full bg-blue-400 p-2 hover:bg-blue-900'>
            <MoveUpRight />
          </button>
        </div>

      </div>

    
  )
}
