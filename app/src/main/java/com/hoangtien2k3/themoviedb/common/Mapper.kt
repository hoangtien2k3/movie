package com.hoangtien2k3.themoviedb.common

interface Mapper<Input, Output> {
    fun map(input: Input): Output
}
