package com.slimshady.weather.data.remote.model.place_details
import android.os.Parcelable
import androidx.room.Entity
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import javax.annotation.Generated

/** @author @buren ---> {Google response for place details}*/
@Entity(tableName = "PlusCode")
@Parcelize
@Generated("com.robohorse.robopojogenerator")
data class PlusCode(
    @field:SerializedName("compound_code")
    var compoundCode: String? = null,

    @field:SerializedName("global_code")
    var globalCode: String? = null
) : Parcelable