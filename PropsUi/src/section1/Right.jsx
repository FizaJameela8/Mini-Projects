import React from 'react'
import { MoveUpRight } from 'lucide-react';
import RightCardContent from './RightCardContent';

function Right(props) {
  return (
    <div className='  h-100 gap-5 w-2/3 p-5 flex flex-nowrap overflow-x-auto'>
      <div className='relative'>
        <div className='h-full w-72 rounded-4xl overflow-hidden'>

          <img
            className='h-full w-full rounded-4xl object-cover'
            src=""
          />

          {props.users.map(function () {
            return <RightCardContent />
          })}
        </div>
      </div>

    </div>


  )
}

export default Right