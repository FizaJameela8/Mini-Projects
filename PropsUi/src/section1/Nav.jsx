import React from 'react'

function Nav() {
  return (
    <div className=" w-full flex justify-between p-5"  >
        <div className="logo">
         <img  className='h-30 w-30 rounded-full' src="https://plus.unsplash.com/premium_vector-1718939146903-080bb3e4c08d?q=80&w=580&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D" />
        </div>
        <div className="">
        <ul className='flex justify-between gap-20' >
            <li className='bg-black text-white rounded-2xl p-2'>Demo website</li>
            <li  className='bg-black text-white rounded-2xl p-2'>Ui design</li>
        </ul>
        </div>
    </div>
  )
}

export default Nav